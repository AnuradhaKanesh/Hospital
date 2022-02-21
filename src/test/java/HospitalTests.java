import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class HospitalTests {

    HospitalService hospitalService;

    @BeforeMethod
    public void before() {
        hospitalService = new HospitalService();
        hospitalService.addPatients(20, true, 2);
        hospitalService.addPatients(10, false, 2);
        hospitalService.addPatients(1, true, 3);
        hospitalService.addPatients(11, true, 3);
        hospitalService.addPatients(50, true, 4);
        hospitalService.addPatients(5, false, 4);
    }

    @Test
    public void shouldGivePercentageOfPatientsFromSameLocation() {

        int sameLocationPatientsPercentage = hospitalService.percentageOfSameLocationPatients(LocalDate.of(2022, 2, 2), LocalDate.of(2022, 2, 4));

        Assert.assertEquals(sameLocationPatientsPercentage, 84);
    }

    @Test
    public void shouldGivePercentageOfPatientsFromOutsideLocation() {

        int outsideLocationPatientsPercentage = hospitalService.percentageOfOutsidePatients(LocalDate.of(2022, 2, 2), LocalDate.of(2022, 2, 4));
        Assert.assertEquals(outsideLocationPatientsPercentage, 15);
    }


}
