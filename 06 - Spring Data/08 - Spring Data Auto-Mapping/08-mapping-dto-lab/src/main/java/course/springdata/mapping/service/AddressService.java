package course.springdata.mapping.service;

import course.springdata.mapping.entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface AddressService {
    List<Address> getAll();
    Address getAddressById(long id);
    Address addAddress(Address address);
    Address updateAddress(Address address);
    Address deleteAddressByID(long id);
    long getAddressCount();

}
