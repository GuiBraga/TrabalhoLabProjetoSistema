package br.com.lab.dev.system.timeControl.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lab.dev.system.timeControl.service.UsuarioService;
import br.com.lab.dev.system.timeControl.service.DTO.UsuarioDTO;
import br.com.lab.dev.system.timeControl.web.rest.util.HeaderUtil;

/**
 * REST controller for managing Usuario.
 */
@Controller
@RequestMapping("/api")
public class UsuarioResource {

	private static final String ENTITY_NAME = "usuario";

	private final UsuarioService usuarioService;

	public UsuarioResource(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/**
	 * POST /usuarios : Create a new usuario.
	 *
	 * @param usuarioDTO
	 *            the usuarioDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new usuarioDTO, or with status 400 (Bad Request) if the usuario
	 *         has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */
	
	@RequestMapping("/novo/usuario")
	@ResponseBody()
	public ResponseEntity<UsuarioDTO> createUsuario(@Validated @RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
		if (usuarioDTO.getIdUsuario() != null) {
			return ResponseEntity.badRequest().headers(
					HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new usuario cannot already have an ID"))
					.body(null);
		}
		UsuarioDTO result = usuarioService.save(usuarioDTO);
		return ResponseEntity.created(new URI("/api/usuarios/" + result.getIdUsuario()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getIdUsuario().toString()))
				.body(result);
	}


	/**
	 * GET /usuarios/:id : get the "id" usuario.
	 *
	 * @param id
	 *            the id of the usuarioDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         usuarioDTO, or with status 404 (Not Found)
	 */

	@RequestMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable Integer id) {
		UsuarioDTO usuarioDTO = usuarioService.findOne(id);
		return Optional.ofNullable(usuarioDTO).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	/**
	 * DELETE /usuarios/:id : delete the "id" usuario.
	 *
	 * @param id
	 *            the id of the usuarioDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@RequestMapping("/delete/usuario/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
		usuarioService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}
}