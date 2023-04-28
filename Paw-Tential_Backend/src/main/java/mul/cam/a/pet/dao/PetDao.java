package mul.cam.a.pet.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.cam.a.pet.dto.PetDto;

@Mapper
@Repository
public interface PetDao {
	int petRegister(PetDto petInfo);
}
