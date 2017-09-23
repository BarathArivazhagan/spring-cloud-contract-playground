package contracts.customer.rest


import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("""
Represents a successful scenario of saving a customer
```
given:
	customer with customer details
when:
	customer to be saved with the given details
then:
	customer gets created
```
""")
	request {
		method 'POST'
		url '/create'
		body(
				customerId: 25,
				customerName: "barath"
		)
		headers {
			contentType(applicationJson())
		}
	}
	response {
		status 200
		body("""
			{
				"customerId": 25,
				"customerName": "barath"
			}
			""")
		headers {
			contentType(applicationJson())
		}
	}
}