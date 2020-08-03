package com.demo.teach.junit5;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Example for parameterized")
public class CheckParameterized {

    AccessStateMachine stateMachine = new AccessStateMachine();

    @ParameterizedTest
    @DisplayName("Test access state machine to clarify whether user can access the page")
    @CsvSource({
            "admin, true",
            "user, false"
    })
    public void testStateMachine(String type, boolean result) {
        assertThat(stateMachine.access(type)).isEqualTo(result);
    }

    interface State {
        boolean access();
    }

    class AdminState implements State {

        @Override
        public boolean access() {
            return true;
        }
    }

    class UserState implements State {


        @Override
        public boolean access() {
            return false;
        }
    }

    class AccessStateMachine {
        private State createState(String type) {
            switch (type) {
                case "user":
                    return new UserState();
                case "admin":
                    return new AdminState();
                default:
                    throw new NullPointerException();
            }
        }

        public boolean access(String type) throws NullPointerException {
            State state = createState(type);
            return state.access();
        }
    }
}
