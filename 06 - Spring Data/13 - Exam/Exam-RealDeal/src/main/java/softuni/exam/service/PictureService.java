package softuni.exam.service;


import org.springframework.data.jpa.repository.Query;
import softuni.exam.models.entities.Picture;

import java.io.IOException;
import java.util.Set;

public interface PictureService {

    boolean areImported();

    String readPicturesFromFile() throws IOException;
	
	String importPictures() throws IOException;

   /* @Query("SELECT p from Picture as p where p.car = :carparam")
	Set<Picture> findAllByCar(@Param(carparam) String car);
*/


}
