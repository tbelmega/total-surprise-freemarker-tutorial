package de.oncoding.freemarkertutorial

import org.hibernate.annotations.GenericGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Controller
class CustomerController {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @GetMapping("/")
    fun getCustomerList(
            model: Model,
            @RequestParam(value = "searchTerm", required = false) name: String?
    ): String {

        val loadedCustomers =
                if (name == null) customerRepository.findAll()
                else customerRepository.findCustomersByName("%" + name + "%")

        model.addAttribute("customers", loadedCustomers)
        return "hello"
    }

    @PostMapping("/create-customer")
    fun createCustomer(
            model: Model,
            firstname:String,
            lastname: String,
            birthyear: Int
    ): String {

        customerRepository.save(
                Customer(
                        id = null,
                        firstname = firstname,
                        lastname = lastname,
                        birthyear = birthyear
                )
        )

        return getCustomerList(model, null)
    }

}

@Entity
data class Customer(
        @Id @GeneratedValue(generator = "native")
        @GenericGenerator(name = "native", strategy = "native")
        val id: Int?,
        val firstname: String,
        val lastname: String,
        val birthyear: Int
) {
    fun getAge(): Int {
        return 2019 - birthyear
    }
}