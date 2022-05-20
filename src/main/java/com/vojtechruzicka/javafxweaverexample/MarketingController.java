package com.vojtechruzicka.javafxweaverexample;

import com.vojtechruzicka.javafxweaverexample.services.MarketerService;
import com.vojtechruzicka.javafxweaverexample.services.RequestService;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("views/AllocatedBudget.fxml")
public class MarketingController {
    private MarketerService marketerService;
    @Autowired
    public MarketingController(MarketerService marketerService)
    {
        this.marketerService = marketerService;
    }

    public void initialize()
    {
        marketerService.getMarketingPlace().join();
    }
}
