package com.farming.system.Repository;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.farming.system.Model.FarmModel;

	public interface FarmRepository extends JpaRepository<FarmModel,Long>{

	}


