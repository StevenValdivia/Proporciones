package org.example;


import org.example.infrastructure.configuration.AppConfig;
import org.example.infrastructure.view.ProporcionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Application
{

    @Autowired
    private ProporcionView proporcionView;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Application app = context.getBean(Application.class);
        app.run();
    }

    public void run() {
        proporcionView.view(); // Llama al método view de ProporcionView
    }
}
