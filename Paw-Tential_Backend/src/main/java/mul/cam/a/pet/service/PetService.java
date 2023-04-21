package mul.cam.a.pet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.cam.a.pet.dao.PetDao;
import mul.cam.a.pet.dto.PetDto;

@Service
@Transactional
public class PetService {
	
	@Autowired
	PetDao dao;
	
	public String petRegister(PetDto petInfo) {
		return dao.petRegister(petInfo) > 0 ? "YES" : "NO";
	}
}
