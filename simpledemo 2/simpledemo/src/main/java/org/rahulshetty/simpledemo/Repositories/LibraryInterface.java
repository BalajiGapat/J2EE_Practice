package org.rahulshetty.simpledemo.Repositories;

import org.rahulshetty.simpledemo.Model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryInterface extends JpaRepository<Library,String>{

}
