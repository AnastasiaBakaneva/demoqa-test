package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.StateAndCityComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitClick = $("#submit"),
            formWrapper = $(".practice-form-wrapper"),
            tableResponsive = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();
    StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        formWrapper.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage lastNameInput(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage userEmailInput(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderWrapperInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String value){
        subjectInput.setValue(value);
        return this;
    }

    public RegistrationPage setHobbies(String value){
        hobbiesWrapperInput.setValue(value);
        return this;
    }

    public RegistrationPage uploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setCity(String value){
        cityInput.scrollIntoView(true);
        cityInput.click();
        stateAndCityComponent.setCity(value);
        return this;

    }

    public RegistrationPage setState(String value){
        stateInput.scrollIntoView(true);
        stateInput.click();
        stateAndCityComponent.setState(value);
        return this;
    }

    public RegistrationPage submitClick(){
        submitClick.scrollIntoView(true);
        submitClick.click();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public void checkFromControl() {
        formWrapper.shouldHave(text("Student Registration Form"));

    }
}

