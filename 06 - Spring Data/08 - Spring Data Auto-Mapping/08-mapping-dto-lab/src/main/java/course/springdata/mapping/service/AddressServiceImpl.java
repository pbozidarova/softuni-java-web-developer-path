package course.springdata.mapping.service;

import course.springdata.mapping.dao.AddressRepository;
import course.springdata.mapping.entity.Address;
import course.springdata.mapping.exception.NonexistingEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService{
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public List<Address> getAll() {
        return this.addressRepository.findAll();
    }

    @Override
    public Address getAddressById(long id) {
        return this.addressRepository.findById(id).orElseThrow(() ->
                new NonexistingEntityException(
                        String.format("Address with ID=%s does not exist.", id))
        );
    }

    @Override
    @Transactional
    public Address addAddress(Address address) {
        address.setId(null);
        return addressRepository.save(address);
    }

    @Override
    @Transactional
    public Address updateAddress(Address address) {
        getAddressById(address.getId());

        return addressRepository.save(address);
    }

    @Override
    @Transactional
    public Address deleteAddressByID(long id) {
        Address removed = getAddressById(id);
        addressRepository.deleteById(id);

        return removed;
    }

    @Override
    public long getAddressCount() {
        return addressRepository.count();
    }
}
