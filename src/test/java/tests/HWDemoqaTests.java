package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class HWDemoqaTests extends TestBase {
    RegistrationPage registracionenPage = new RegistrationPage();

    @Test
    void PositiveTests() {

        registracionenPage.openPage()
                .setFirstName("Anastasia")
                .lastNameInput("Bakaneva")
                .userEmailInput("anastasia@mail.ru")
                .setGender("Female")
                .setUserNumber("89816987655")
                .setDateOfBirth("28", "January", "2025")
                .setSubjects("SBP")
                .setHobbies("Sports")
                .uploadPicture("icon1.png")
                .setAddress("SBP, Kolpino")
                .setState("NCR")
                .setCity("Delhi")
                .submitClick()
                .checkResult("Student Name", "Anastasia" + " " + "Bakaneva")
                .checkResult("Student Email", "anastasia@mail.ru")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "89816987655")
                .checkResult("Date of Birth", "28" + "January" + "2025")
                .checkResult("Subjects", "SBP")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "icon1.png")
                .checkResult("Address", "SBP, Kolpino")
                .checkResult("State and City", "NCR" + "Delhi");
    }

    @Test
    void allRequiredForm(){
        registracionenPage.openPage()
                .setFirstName("Anastasia")
                .lastNameInput("Bakaneva")
                .setGender("Female")
                .setUserNumber("89816987655")
                .setDateOfBirth("28", "January", "2025")
                .submitClick()
                .checkResult("Student Name", "Anastasia" + " " + "Bakaneva")
                .checkResult("Gender", "Female")
                .checkResult("Mobile","Mobile 8981698765")
                .checkResult("Date of Birth", "Date of Birth 28 January,2025");




    }
}
