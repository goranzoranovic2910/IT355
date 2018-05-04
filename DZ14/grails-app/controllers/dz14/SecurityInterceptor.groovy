package dz14


class SecurityInterceptor {


    SecurityInterceptor() {
        matchAll()
        .except(controller:'student', action:'login')
    }

    boolean before() {
        if (!session.user && actionName != "login") {
            redirect(controller: "student", action: "login")
            return false
        }
        return true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
