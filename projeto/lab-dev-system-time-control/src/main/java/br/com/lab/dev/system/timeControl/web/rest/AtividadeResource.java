package br.com.lab.dev.system.timeControl.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lab.dev.system.timeControl.service.AtividadeService;
import br.com.lab.dev.system.timeControl.service.DTO.AtividadeDTO;
import br.com.lab.dev.system.timeControl.web.rest.util.HeaderUtil;

/**
 * REST controller for managing Atividade.
 */
@RestController
@RequestMapping("/api")
public class AtividadeResource {

	private static final String ENTITY_NAME = "atividade";

	private final AtividadeService atividadeService;

	public AtividadeResource(AtividadeService atividadeService) {
		this.atividadeService = atividadeService;
	}

	/**
	 * POST /atividades : Create a new atividade.
	 *
	 * @param atividadeDTO
	 *            the atividadeDTO to create
	 * @return the ResponseEntity with status 201 (Created) and with body the
	 *         new atividadeDTO, or with status 400 (Bad Request) if the atividade
	 *         has already an ID
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */

	@RequestMapping("/novaAtividade")
	public ResponseEntity<AtividadeDTO> createAtividade(@Validated @RequestBody AtividadeDTO atividadeDTO) throws URISyntaxException {
		if (atividadeDTO.getIdAtividade() != null) {
			return ResponseEntity.badRequest().headers(
					HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new atividade cannot already have an ID"))
					.body(null);
		}
		AtividadeDTO result = atividadeService.save(atividadeDTO);
		return ResponseEntity.created(new URI("/api/atividades/" + result.getIdAtividade()))
				.headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getIdAtividade().toString()))
				.body(result);
	}

	/**
	 * PUT /atividades : Updates an existing atividade.
	 *
	 * @param atividadeDTO
	 *            the atividadeDTO to update
	 * @return the ResponseEntity with status 200 (OK) and with body the updated
	 *         atividadeDTO, or with status 400 (Bad Request) if the atividadeDTO is
	 *         not valid, or with status 500 (Internal Server Error) if the
	 *         atividadeDTO couldnt be updated
	 * @throws URISyntaxException
	 *             if the Location URI syntax is incorrect
	 */

	@RequestMapping("/editar/atividade")
	public ResponseEntity<AtividadeDTO> updateAtividade(@Validated @RequestBody AtividadeDTO atividadeDTO)
			throws URISyntaxException {
		if (atividadeDTO.getIdAtividade() == null) {
			return createAtividade(atividadeDTO);
		}
		AtividadeDTO result = atividadeService.save(atividadeDTO);
		return ResponseEntity.ok()
				.headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, atividadeDTO.getIdAtividade().toString()))
				.body(result);
	}

	/**
	 * GET /atividades/:id : get the "id" atividade.
	 *
	 * @param id
	 *            the id of the atividadeDTO to retrieve
	 * @return the ResponseEntity with status 200 (OK) and with body the
	 *         atividadeDTO, or with status 404 (Not Found)
	 */

	@RequestMapping("/atividade/{id}")
	public ResponseEntity<AtividadeDTO> getAtividade(@PathVariable Long id) {
		AtividadeDTO atividadeDTO = atividadeService.findOne(id);
		return Optional.ofNullable(atividadeDTO).map(result -> new ResponseEntity<>(result, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
//	/**
//     * GET  /beneficiarios : get all the beneficiarios.
//     *
//     * @param pageable the pagination information
//     * @return the ResponseEntity with status 200 (OK) and the list of beneficiarios in body
//     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
//     */
//    @RequestMapping("/atividades")
//    public ResponseEntity<List<AtividadeDTO>> getAllAtividades()
//        throws URISyntaxException {
//        List<AtividadeDTO> atividades = atividadeService.findAll();
//        return new ResponseEntity<>(atividades);
//    }

	/**
	 * DELETE /atividades/:id : delete the "id" atividade.
	 *
	 * @param id
	 *            the id of the atividadeDTO to delete
	 * @return the ResponseEntity with status 200 (OK)
	 */
	@RequestMapping("/delete/atividade/{id}")
	public ResponseEntity<Void> deleteAtividade(@PathVariable Long id) {
		atividadeService.delete(id);
		return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
	}

}
