package pe.negocio.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.negocio.model.Instructor;
import pe.negocio.service.InstructorService;

@RestController
@RequestMapping("/instructor")
public class InstructorRestController {
	
	@Autowired
	private InstructorService instructorService;
	
	@GetMapping("/listar") // Http Method GET
	public ResponseEntity<?> listar() {
		Collection<Instructor> itemsInstructor=instructorService.findAll();
		return new ResponseEntity<>(itemsInstructor,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{instructorId}") // Http Method GET
	public ResponseEntity<?> buscar(@PathVariable Integer instructorId) {
		Instructor instructorDb=instructorService.findById(instructorId);
		if (instructorDb!=null) {
			return new ResponseEntity<>(instructorDb, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/agregar") // Http Method POST
	public ResponseEntity<?> agregar(@RequestBody Instructor instructor) {
		instructorService.insert(instructor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/editar/{instructorId}") // Http Method PUT
	public ResponseEntity<?> editar(@PathVariable Integer instructorId,
										@RequestBody Instructor newInstructor) {
		Instructor instructorDb=instructorService.findById(instructorId);
		if (instructorDb!=null) {
			instructorDb.setNombre(newInstructor.getNombre());
			instructorDb.setApellidos(newInstructor.getApellidos());
			instructorDb.setPassword(newInstructor.getPassword());
			instructorDb.setEmail(newInstructor.getEmail());
			instructorDb.setFregistro(newInstructor.getFregistro());
			instructorService.update(instructorDb);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/borrar/{instructorId}") // Http Method DELETE
	public ResponseEntity<?> borrar(@PathVariable Integer instructorId)
	{
		Instructor instructorDb=instructorService.findById(instructorId);
		
		if (instructorDb!=null) {
			instructorService.delete(instructorId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
