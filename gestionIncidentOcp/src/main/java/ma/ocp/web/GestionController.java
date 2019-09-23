package ma.ocp.web;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import ma.ocp.dao.Case2Repository;
import ma.ocp.dao.Case3Repository;
import ma.ocp.dao.IncidentRepository;
import ma.ocp.entities.Incident;
import ma.ocp.entities.Case2;
import ma.ocp.entities.Case3;


@RestController
public class GestionController {
	
	@Autowired
	private IncidentRepository incidentRepository;
	
	@Autowired
	private Case2Repository case2Repository;
	
	@Autowired
	private Case3Repository case3Repository;
	

	
	@GetMapping(path = "/photoPoduct/{image}",produces = {MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
	public byte[] getPhoto(@PathVariable("image") String image)throws Exception{
		
		
	
		return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/projetPFE/"+image));
	
	
		
	}
	@PostMapping(path = "/uploadPhoto/{numPhoto}")
	public void uploadPhoto(MultipartFile file,@PathVariable String numPhoto)throws Exception{
		
		String extension = FilenameUtils.getExtension(file.getOriginalFilename());
		String nom=numPhoto+"."+extension;

		Files.write(Paths.get(System.getProperty("user.home")+"/projetPFE/"+nom),file.getBytes());

	}
	
	
	@GetMapping(path = "/case22s")
	public List<Case2> tousCase2(){
		
		
      return case2Repository.findAll();
	}
	
	@GetMapping(path = "/case33")
	public List<Case3> tousCase3(){
		
		
      return case3Repository.findAll();
	}
	
	

}
