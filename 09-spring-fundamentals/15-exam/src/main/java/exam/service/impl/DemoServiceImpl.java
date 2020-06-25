package exam.service.impl;

import exam.repository.DemoRepository;
import exam.service.DemoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    private final DemoRepository demoRepository;
    private final ModelMapper modelMapper;

    public DemoServiceImpl(DemoRepository demoRepository, ModelMapper modelMapper) {
        this.demoRepository = demoRepository;
        this.modelMapper = modelMapper;
    }
}
