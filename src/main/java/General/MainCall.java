package General;

import Objects.RAF_passenger;
import Objects.loginPage;
import Objects.registrationPage;
import Objects.*;
import com.relevantcodes.extentreports.ExtentReports;

import static Config.configProperties.Environment;

public class MainCall {

    static ExtentReports extent;
    public static String emailToLogin = "";

    public static ExtentReports startReport()
    {
        extent = new ExtentReports(System.getProperty("user.dir") + "/reports/ExtentReport.html", true);
        extent.addSystemInfo("Environment", Environment);
        return extent;
    }

    public static ExtentReports getExtentReport()
    {
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }


    public final static registrationPage registerPage = new registrationPage();
    public final static myAccountPages myAccount = new myAccountPages();
    public final static UnknownAirportPage unknownAirport = new UnknownAirportPage();
    public final static editPastFlightPage editPastflightLeg = new editPastFlightPage();
    public final static requestQuoteDirectPage quoteDirectPage = new requestQuoteDirectPage();
    public final static passportExpiryMyAccPage passportExpiry = new passportExpiryMyAccPage();
    public final static loginPage loginPage = new loginPage();
    public final  static myaccountpage myaccountPage = new myaccountpage();
    public final static RAF_passenger RAF_passenger = new RAF_passenger();

    public final static SimulateFlightPage SimulateFlightPage = new SimulateFlightPage();
    public final static loginPage LOGIN_PAGE = new loginPage();
    public final static requestFlightPage reqflightPage = new requestFlightPage();
    public final static CanNotRequestFlightPage reqfnegPage = new CanNotRequestFlightPage();
    public final static FlightEntertainment entertainments = new FlightEntertainment();
    public final static HowToFly htfv = new HowToFly();

    public final static ReturnFlightPage ReturnFlightPage = new ReturnFlightPage();
    public final static ELOffersPage ELOffersPage = new ELOffersPage();
    public final static TopUpPage TopUpPage = new TopUpPage();
    public final static TransportServicesPage TransportServicesPage = new TransportServicesPage();

    public final static requestFlightPage requestPage = new requestFlightPage();
    public final static MyItineraryPage itineraryPage = new MyItineraryPage();
    public final static customerFeedbackPage feedbackPage = new customerFeedbackPage();
    public final static PaymentMethodsPage paymentPage = new PaymentMethodsPage();
    public final static MyAccount_FSP_VJDirect MY_ACCOUNT_FSP_VJ_DIRECT  = new MyAccount_FSP_VJDirect();
    public final static forgotpasswordPage forgotpasswordPage = new forgotpasswordPage();
    public final static GenericFunctions GENERIC_FUNCTIONS = new GenericFunctions();
    public final static requestquotePage REQUESTQUOTE_PAGE = new requestquotePage();
    public final static PopularDestinationFlowPage POPULAR_DESTINATION_FLOW_PAGE = new PopularDestinationFlowPage();
    public final static MembershipFlowPage membership = new MembershipFlowPage();
    public final static PlanFlightPage PLAN_FLIGHT_PAGE = new PlanFlightPage();

    public final static String username = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    public final static String emailid = MainCall.GENERIC_FUNCTIONS.generateEmail(username);
    public final static String lastname = MainCall.GENERIC_FUNCTIONS.generateRandomString(5);
    public final static String phonenum = MainCall.GENERIC_FUNCTIONS.generateRandomNum(7);

    public final static AccountDetailsPage accountDetailsPage = new AccountDetailsPage();
    public final static quotesPage quotesPage1 = new quotesPage();
    public final static changePassword changePassword = new changePassword();
    public final static addPassengerAndPassportPage addPaxPass = new  addPassengerAndPassportPage();

    public final static AtEvent_Login login_page1 = new AtEvent_Login();
    public final static Switch_AddNewGroup group = new Switch_AddNewGroup();

}
