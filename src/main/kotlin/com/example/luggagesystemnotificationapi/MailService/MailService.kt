package com.example.luggagesystemnotificationapi.MailService

import com.resend.sdk.Resend
import com.resend.sdk.models.operations.SendEmailRequest
import com.resend.sdk.models.operations.SendEmailResponse
import com.resend.sdk.models.shared.Email
import com.resend.sdk.models.shared.Security
import org.springframework.stereotype.Service

@Service
object MailService {
    suspend fun sendWelcomeMail(nameOfUser: String): SendEmailResponse {

        val resendBuilder = Resend.builder()
        resendBuilder.setSecurity(Security().withBearerAuth("Bearer re_NA9aRFw5_BrRMu9cfzpUBZfRsd67NnUEq"))
        val resend = resendBuilder.build()
        val sendEmailRequest = SendEmailRequest().apply {
            request = Email().apply {
                from = "onboarding@resend.dev"
                html = ""
                subject = "Welcome  $nameOfUser!  " +
                    "the Our  EasyCarry  Family! "
                text = "You registered our system so we are so happy!"
                to = "190706015@st.maltepe.edu.tr"
            }
        }
        return resend.email.sendEmail(sendEmailRequest)

    }


}