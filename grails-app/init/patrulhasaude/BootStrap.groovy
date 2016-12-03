package patrulhasaude

import patrulhasaude.seguranca.Role
import patrulhasaude.seguranca.User
import patrulhasaude.seguranca.UserRole

class BootStrap {

    def init = { servletContext ->

        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority: 'ROLE_USER').save()

        def testUser = new User(username: 'me', password: 'password').save()

        UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        assert User.count() == 1
        assert Role.count() == 2
        assert UserRole.count() == 1

    }
    def destroy = {
    }
}
