CREATE TABLE IF NOT EXISTS components (
    id serial NOT NULL,
    component text NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS recipes (
    id serial NOT NULL,
    name text NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS recipes_components (
    id serial NOT NULL,
    id_recipe integer NOT NULL,
    id_component integer NOT NULL,
    amount integer NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT component_fk FOREIGN KEY (id_component)
        REFERENCES components (id) ON DELETE CASCADE,
    CONSTRAINT recipe_fk FOREIGN KEY (id_recipe)
        REFERENCES recipes (id) ON DELETE CASCADE
);