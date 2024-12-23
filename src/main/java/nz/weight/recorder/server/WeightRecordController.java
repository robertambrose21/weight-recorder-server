package nz.weight.recorder.server;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("records")
@RequiredArgsConstructor
@CrossOrigin
public class WeightRecordController {

    private final WeightRecordRepository weightRecordRepository;

    @GetMapping
    public List<WeightRecordDTO> getWeights() {
        return weightRecordRepository.findAll().stream()
                .map(dao -> WeightRecordDTO.builder().weight(dao.getWeight()).date(dao.getDate()).build())
                .toList();
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public WeightRecordDTO addRecord(@RequestBody final WeightRecordDTO record) {
        final WeightRecordDAO dto = WeightRecordDAO.builder()
                .date(record.date())
                .weight(record.weight())
                .build();

        weightRecordRepository.save(dto);

        return record;
    }

}
