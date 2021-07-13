package ru.balmukanov.palantir.application.api.event;

import org.springframework.context.ApplicationEvent;
import ru.balmukanov.palantir.domain.User;

public class SearchUserCompletedEvent extends ApplicationEvent {
    private static final long serialVersionUID = -628210345830131987L;

    public SearchUserCompletedEvent(User source) {
        super(source);
    }

    @Override
    public User getSource() {
        return (User) super.getSource();
    }
}
