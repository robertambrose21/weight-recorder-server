package nz.weight.recorder.server;

import lombok.Builder;

import java.time.Instant;

@Builder
public record WeightRecordDTO(double weight, Instant date) {

}
