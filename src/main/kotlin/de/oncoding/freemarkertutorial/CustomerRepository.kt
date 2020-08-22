package de.oncoding.freemarkertutorial

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CustomerRepository : JpaRepository<Customer, Int> {

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM customer WHERE lastname LIKE ?1 OR firstname LIKE ?1"
    )
    fun findCustomersByName(searchTerm: String): List<Customer>
}