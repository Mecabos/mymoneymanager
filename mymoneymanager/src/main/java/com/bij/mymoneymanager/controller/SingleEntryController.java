package com.bij.mymoneymanager.controller;

import com.bij.mymoneymanager.dto.singleentry.SingleEntryDto;
import com.bij.mymoneymanager.dto.singleentry.SingleEntryForCreationDto;
import com.bij.mymoneymanager.model.SingleEntry;
import com.bij.mymoneymanager.service.SingleEntryService;
import com.bij.mymoneymanager.util.DTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/SingleEntries")
public class SingleEntryController {

    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private SingleEntryService singleEntryService;

    @PostMapping
    @ResponseBody
    public SingleEntryDto addSingleEntry(@DTO(SingleEntryForCreationDto.class) SingleEntry singleEntry) {
        return modelMapper.map(singleEntryService.add(singleEntry), SingleEntryDto.class);
    }

    @PostMapping("/batch")
    @ResponseBody
    public List<SingleEntryDto> addMiltipleSingleEntry(@RequestBody List<SingleEntryForCreationDto> singleEntryForCreationDtoList) {
        return
                modelMapper.map(
                        singleEntryService.addAll(modelMapper.map(
                                singleEntryForCreationDtoList,
                                new TypeToken<List<SingleEntry>>() {}.getType()
                        )),
                        new TypeToken<List<SingleEntryDto>>() {}.getType()
                );
        /*return singleEntryService.addAll(
                singleEntryForCreationDtoList.stream()
                        .map(sed -> modelMapper.map(sed, SingleEntry.class))
                        .collect(Collectors.toList())
        )
                .stream()
                .map(se-> modelMapper.map(se, SingleEntryDto.class))
                .collect(Collectors.toList());*/
    }

    @PutMapping
    public void updateSingleEntry(@DTO(SingleEntryDto.class) SingleEntry singleEntry) {
        singleEntryService.update(singleEntry);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public SingleEntryDto getSingleEntry(@PathVariable int id) {
        return modelMapper.map(singleEntryService.get(id), SingleEntryDto.class);
    }

    @GetMapping
    @ResponseBody
    public List<SingleEntryDto> getAllSingleEntries() {
        return singleEntryService.getAll().stream().map(e -> modelMapper.map(e, SingleEntryDto.class)).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void removeSingleEntry(@PathVariable int id) {
        singleEntryService.remove(id);
    }


}
