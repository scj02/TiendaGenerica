package co.edu.unbosque.msproveedores.service;

import co.edu.unbosque.msproveedores.model.Provider;
import co.edu.unbosque.msproveedores.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> findAll() {
        return providerRepository.findAll();
    }

    public Optional<Provider> findById(Long id) {
        return providerRepository.findById(id);
    }

    public Provider save(Provider provider) {
        return providerRepository.save(provider);
    }

    public void deleteById(Long id) {
        providerRepository.deleteById(id);
    }

    public Provider update(Long id, Provider providerDetails) {
        return providerRepository.findById(id).map(provider -> {
            provider.setNit(providerDetails.getNit());
            provider.setName(providerDetails.getName());
            provider.setAddress(providerDetails.getAddress());
            provider.setPhone(providerDetails.getPhone());
            return providerRepository.save(provider);
        }).orElseThrow(() -> new RuntimeException("Provider not found with id " + id));
    }
}
