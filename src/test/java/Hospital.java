import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter

public class Hospital {

    String name;
    List<Patient> patientsList;

    Hospital() {
        this.patientsList = new ArrayList<>();
    }

    public void addOutPatients(Patient... patients) {
        this.patientsList.addAll(List.of(patients));
    }
}
