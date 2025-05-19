package tacos.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import tacos.data.OrderRepository;
import tacos.domain.TacoOrder;

import static tacos.util.LoggerUtil.toJson;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping("/current")
    public String orderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus){
        if (errors.hasErrors()) {
            return "orderForm";
        }
        var savedOrder = orderRepository.save(tacoOrder);
        log.info("Order submitted: {}", toJson(savedOrder));
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
