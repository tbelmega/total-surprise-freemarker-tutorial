package de.oncoding.freemarkertutorial

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.persistence.Entity
import javax.persistence.Id

@Controller
class HelloController {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @GetMapping("/")
    fun hello(
            model: Model,
            @RequestParam(value = "searchTerm", required = false) name: String?
    ): String {

        val loadedCustomers =
                if (name == null) customerRepository.findAll()
                else customerRepository.findCustomersByName("%" + name + "%")

        model.addAttribute("customers", loadedCustomers)
        return "hello"
    }

}

@Entity
data class Customer(
        @Id val id: Int,
        val firstname: String,
        val lastname: String,
        val birthyear: Int
) {
    fun getAge(): Int {
        return 2019 - birthyear
    }
}