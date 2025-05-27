const { gql } = require('apollo-server');

const typeDefs = gql`
    type Poeta {
        poet_code: Int
        first_name: String
        surname: String
        address: String
        postcode: String
        telephone_number: String
    }

    type Poema {
        poem_code: Int
        poem_title: String
        poem_contents: String
        poet_code: Int
    }

    type Customer {
        customer_code: Int
        first_name: String
        surname: String
        address: String
        postcode: String
        telephone_number: String
    }

    type Sale {
        sale_code: Int
        date: String
        amount: Float
        customer_code: Int
    }

    type Publication {
        publication_code: Int
        title: String
        price: Float
    }

    type Poemasview {
        poem_code: Int
        poem_title: String
        poem_contents: String
        poet_code: Int
        first_name: String
        surname: String
    }

    type Poem_Publication {
        poem_code: Int
        publication_code: Int
    }

    type Sale_Publication {
        sale_code: Int
        publication_code: Int
    }

    type Query {
        obtener_poeta: [Poeta]
        obtener_poema(poet_code: Int!): [Poemasview]
    }

    type Mutation {
        createPoeta(
            poet_code: Int,
            first_name: String!,
            surname: String!,
            address: String!,
            postcode: String!,
            telephone_number: String!): Poeta

        createPoema(
            poem_code: Int,
            poem_title: String!,
            poem_contents: String!,
            poet_code: Int!): Poema

        createCustomer(
            customer_code: Int,
            first_name: String!,
            surname: String!,
            address: String!,
            postcode: String!,
            telephone_number: String!): Customer

        createSale(
            sale_code: Int,
            date: String!,
            amount: Float!,
            customer_code: Int!): Sale

        createPublication(
            publication_code: Int!,
            title: String!,
            price: Float!): Publication

        updateCustomer(
            customer_code: Int!,
            first_name: String,
            surname: String,
            address: String,
            postcode: String,
            telephone_number: String): Customer

        updatePublication(
            publication_code: Int!,
            title: String,
            price: Float): Publication

        updateSale(
            sale_code: Int!,
            date: String,
            amount: Float,
            customer_code: Int): Sale

        createPoem_Publication(
            poem_code: Int!,
            publication_code: Int!): Poem_Publication

        deletePoem_Publication(
            poem_code: Int!,
            publication_code: Int!): String

        createSale_Publication(
            sale_code: Int!,
            publication_code: Int!): Sale_Publication

        deleteSale_Publication(
            sale_code: Int!,
            publication_code: Int!): String
    }
`;

module.exports = typeDefs;
