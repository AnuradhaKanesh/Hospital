import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class HospitalService {

    Hospital hospital;

    HospitalService() {
        this.hospital = new Hospital();
    }

    public void addPatients(int noOfPatients, boolean isFromOutsideLocation, int dayOfMonth) {
        Patient patient = null;
        for (int i = 0; i < noOfPatients; i++) {
            hospital.patientsList.add(patient.builder().name(String.format("%s", UUID.randomUUID())).
                    isFromOutsideLocation(isFromOutsideLocation).OPDate(LocalDate.of(2022, 2, dayOfMonth)).build());
        }
    }

    private int patientsFromOutsideLocationForDateRange(LocalDate fromDate, LocalDate toDate) {
        List outsidePatients = hospital.patientsList.stream().filter(patient -> !patient.isFromOutsideLocation()
                && (patient.getOPDate().isAfter(fromDate.minusDays(1)) && patient.getOPDate().isBefore(toDate.plusDays(1)))).collect(Collectors.toList());
        return outsidePatients.size();
    }

    private int patientsFromSameLocationForDateRange(LocalDate fromDate, LocalDate toDate) {
        List outsidePatients = hospital.patientsList.stream().filter(patient -> patient.isFromOutsideLocation()
                && (patient.getOPDate().isAfter(fromDate.minusDays(1)) && patient.getOPDate().isBefore(toDate.plusDays(1)))).collect(Collectors.toList());
        return outsidePatients.size();
    }

    private int totalPatientsForDateRange(LocalDate fromDate, LocalDate toDate) {
        List totalPatients = hospital.patientsList.stream().filter(patient ->
                patient.getOPDate().isAfter(fromDate.minusDays(1)) && patient.getOPDate().isBefore(toDate.plusDays(1))).collect(Collectors.toList());
        return totalPatients.size();
    }

    public int percentageOfOutsidePatients(LocalDate fromDate, LocalDate toDate) {
        int result = (int) ((Double.valueOf(patientsFromOutsideLocationForDateRange(fromDate, toDate))
                / Double.valueOf(totalPatientsForDateRange(fromDate, toDate))) * 100);
        return result;
    }

    public int percentageOfSameLocationPatients(LocalDate fromDate, LocalDate toDate) {
        int result = (int) ((Double.valueOf(patientsFromSameLocationForDateRange(fromDate, toDate))
                / Double.valueOf(totalPatientsForDateRange(fromDate, toDate))) * 100);
        return result;
    }

}
