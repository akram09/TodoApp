package oxxy.kero.roiaculte.team7.domain.exception


sealed class Failure {
    class NetworkConnection: Failure()
    class ServerError: Failure()

    class DataBaseError(t:Throwable):Failure()
    /** * Extend this class for feature specific failures.*/
    abstract class FeatureFailure: Failure()

}
