package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.entities.Branch;
import hiberspring.domain.models.BranchesSeedDto;
import hiberspring.repository.BranchRepository;
import hiberspring.repository.TownRepository;
import hiberspring.service.BranchService;
import hiberspring.service.TownService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static hiberspring.common.GlobalConstants.BRANCHES_FILE_PATH;
import static hiberspring.common.GlobalConstants.SUCCESSFUL_IMPORT_MESSAGE;

@Service
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownService townService;

    public BranchServiceImpl(BranchRepository branchRepository, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, TownService townService) {
        this.branchRepository = branchRepository;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townService = townService;
    }


    @Override
    public Boolean branchesAreImported() {
        return this.branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files.readString(Paths.get(BRANCHES_FILE_PATH));
    }

    @Override
    public String importBranches(String branchesFileContent) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        BranchesSeedDto[] branchesSeedDtos = this.gson.fromJson(new FileReader(BRANCHES_FILE_PATH), BranchesSeedDto[].class);

        Arrays.stream(branchesSeedDtos).forEach(branchesSeedDto -> {
            if (this.validationUtil.isValid(branchesSeedDto)) {
                if (this.branchRepository.findAllByName(branchesSeedDto.getName()) == null) {
                    Branch branch = new Branch();
                    branch.setName(branchesSeedDto.getName());

                    if (this.townService.getTownByName(branchesSeedDto.getTown()) == null) {
                        sb.append("No such town exists in the database");
                    } else {
                        branch.setTown(this.townService.getTownByName(branchesSeedDto.getTown()));
                        sb.append(String.format(SUCCESSFUL_IMPORT_MESSAGE, "Branch", branchesSeedDto.getName()));
                        this.branchRepository.saveAndFlush(branch);
                    }
                } else {
                    sb.append("This branch is already in the database!");
                }
            } else {
                sb.append(GlobalConstants.INCORRECT_DATA_MESSAGE);
            }
            sb.append(System.lineSeparator());

        });

        return sb.toString();
    }
}
