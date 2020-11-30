package coronavirus.coronavirustracker.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationStats {
    private String state;
    private String country;
    private int latestTotalCases;
    private int newCases;

}
