const db = require('../../database/db');

const poetResolvers = {
    Query: {
        obtener_poeta: async () => await db('Poeta'),

        obtener_poema: async (_, { poet_code }) => {
            console.log("poet_code recibido:", poet_code);
            if (poet_code == null) {
                throw new Error("El parámetro 'poet_code' es obligatorio");
            }

            const result = await db.raw("SELECT * FROM PoemasView WHERE poet_code = ?", [poet_code]);
            return result[0]; // En MySQL con knex, las filas están en result[0]
        }
    },

    Mutation: {
        createPoeta: async (_, args) => {
            await db('Poeta').insert(args);
            return args;
        },

        createPoema: async (_, args) => {
            const [id] = await db('Poema').insert(args);
            return { poem_code: id, ...args };
        },

        createCustomer: async (_, args) => {
            const [id] = await db('Customer').insert(args);
            return { customer_code: id, ...args };
        },

        updateCustomer: async (_, args) => {
            const { customer_code, ...data } = args;
            await db('Customer').where({ customer_code }).update(data);
            const updatedCustomer = await db('Customer').where({ customer_code }).first();
            return updatedCustomer;
        },

        createSale: async (_, args) => {
            const [id] = await db('Sale').insert(args);
            return { sale_code: id, ...args };
        },

        updateSale: async (_, args) => {
            const { sale_code, ...data } = args;
            await db('Sale').where({ sale_code }).update(data);
            const updated = await db('Sale').where({ sale_code }).first();
            return updated;
        },

        createPublication: async (_, args) => {
            const [id] = await db('Publication').insert(args);
            return { publication_code: id, ...args };
        },

        updatePublication: async (_, args) => {
            const { publication_code, ...data } = args;
            await db('Publication').where({ publication_code }).update(data);
            const updated = await db('Publication').where({ publication_code }).first();
            return updated;
        },

        createPoem_Publication: async (_, { poem_code, publication_code }) => {
            const [id] = await db('Poem_Publication').insert({ poem_code, publication_code });
            return { poem_code, publication_code };
        },

        deletePoem_Publication: async (_, { poem_code, publication_code }) => {
            await db('Poem_Publication')
                .where({ poem_code, publication_code })
                .del();
            return "Poem_Publication borrado"; 
        },

        createSale_Publication: async (_, { sale_code, publication_code }) => {
            const [id] = await db('Sale_Publication').insert({ sale_code, publication_code });
            return { sale_code, publication_code };
        },

        deleteSale_Publication: async (_, { sale_code, publication_code }) => {
            await db('Sale_Publication')
                .where({ sale_code, publication_code })
                .del();
            return "Sale_Publication borrado"; 
        }
    }
};

module.exports = poetResolvers;
