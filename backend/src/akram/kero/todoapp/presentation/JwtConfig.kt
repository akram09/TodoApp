package akram.kero.todoapp.presentation

import com.auth0.jwt.JWT
import com.auth0.jwt.JWTVerifier
import com.auth0.jwt.algorithms.Algorithm

object JwtConfig{
    private val algorithme = Algorithm.HMAC256("todo_app")
    private val issuer = "ktor.io_issuer"
    val jwtVerifier :JWTVerifier =
        JWT.require(algorithme)
            .withIssuer(issuer)
            .build()

    fun makeToken(userId:String  ):String {
            return JWT.create()
                .withClaim("UserId", userId)
                .withSubject("Authentification")
                .withIssuer(issuer)
                .sign(algorithme)
    }

}