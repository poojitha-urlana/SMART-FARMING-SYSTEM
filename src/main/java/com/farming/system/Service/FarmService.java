package com.farming.system.Service;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.farming.system.Model.FarmModel;
	import com.farming.system.Repository.FarmRepository;

	import java.util.List;
	import java.util.Optional;

	@Service
	public class FarmService {

	    @Autowired
	    private FarmRepository farmrepo;

	    public FarmModel save(FarmModel farm) {
	        return farmrepo.save(farm);
	    }

	    public List<FarmModel> getAllFarm() {
	        return farmrepo.findAll();
	    }

	    public FarmModel update(Long id, FarmModel farm) {
	        Optional<FarmModel> existingFarm = farmrepo.findById(id);
	        if (existingFarm.isPresent()) {
	            FarmModel farmToUpdate = existingFarm.get();
	            farmToUpdate.setName(farm.getName());
	            farmToUpdate.setLocation(farm.getLocation());
	            farmToUpdate.setSize(farm.getSize());
	            farmToUpdate.setFarmStatus(farm.getFarmStatus());
	            return farmrepo.save(farmToUpdate);
	        }
	        throw new RuntimeException("Farm not found with id: " + id); // Improved handling
	    }

	    public boolean delete(Long id) {
	        if (farmrepo.existsById(id)) {
	            farmrepo.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	

}
