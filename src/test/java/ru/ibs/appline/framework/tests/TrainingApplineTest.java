package ru.ibs.appline.framework.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.ibs.appline.framework.basetestsclass.BaseTest;

@DisplayName("Второе задание")
public class TrainingApplineTest extends BaseTest {

    @Test()
    @DisplayName("Оформление заявки на командировку")
    @Tag("Test_PageObject_1")
    public void ApplyingForBusinessTrip() {
        String departureCity = "Энгельс";
        String arrivalCity = "Москва";
        String departureDate = "10.11.2023";
        String returnDate = "10.12.2023";
        String organisationName = "(Хром) Призрачная Организация Охотников";
        String checkboxValue = "Заказ билетов";

        webSite.getLoginPage()
                .authorisation()
                .checkMainPageTitle()
                .selectBusinessTripModuleInCostsBlock()
                .clickCreateBusinessTripButton()
                .checkCreateBusinessTripTitle()
                .chooseInternalDevelopmentDepartment()
                .clickOpenListButton()
                .chooseOrganisation(organisationName)
                .selectTasksCheckBox(checkboxValue)
                .fillTravelFields(departureCity)
                .fillTravelFields(arrivalCity)
                .fillTravelFields(departureDate)
                .fillTravelFields(returnDate)
                .checkAllFieldsFilled(organisationName)
                .checkAllFieldsFilled(checkboxValue)
                .checkAllFieldsFilled(departureCity)
                .checkAllFieldsFilled(arrivalCity)
                .checkAllFieldsFilled(departureDate)
                .checkAllFieldsFilled(returnDate)
                .clickSaveAndCloseButton()
                .checkErrorMessage("Список командируемых сотрудников не может быть пустым");
    }
}
