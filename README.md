# Relaciones de tipo ManyToMany en Spring Boot

## Explicación teórica breve

Una relación de muchos a muchos con atributos en una base de datos relacional se refiere a la conexión entre múltiples registros de dos o más tablas en la que cada uno de ellos puede estar relacionado con varios registros en otra tabla y tienen atributos específicos que definen esa relación. Estas tablas resultantes de la relación de muchos a muchos se denominan entidades de interacción o asociativas, y en muchos casos, representan procesos de negocios o actividades de la empresa en sí. Es importante tener en cuenta que toda entidad generada en este tipo de relación debe contar con atributos asociados, aunque existen algunas excepciones a esta regla en ciertas ocasiones.

## Explicación del mapeo de una entidad asociativa con atributos en Spring Boot

La relación entre migrantes y redes sociales es de muchos a muchos, lo que significa que un migrante puede estar vinculado con varias redes sociales y una red social puede estar vinculada con varios migrantes. Para modelar esta relación en Spring Boot, normalmente se utiliza la anotación `@ManyToMany` y `@JoinTable` en la clase Migrante, con las propiedades `name`, `joinColumns` e `inverseJoinColumns`, y la anotación `@ManyToMany(mappedBy = "redesSociales")` en la clase RedSocial. Cada clase debe tener una lista de objetos de la otra clase (para la clase Migrante, una lista de objetos de RedSocial llamada "redesSociales", y para la clase RedSocial, una lista de objetos Migrante llamada "migranteList").

Sin embargo, en algunos casos, como en este ejemplo, la tabla intermedia generada por la relación muchos a muchos entre estas dos clases puede contener más que solo los IDs de las clases, que funcionan como llaves foráneas que representan la relación. En este caso, la tabla intermedia denominada "MigranteRedSocialRel" contiene un atributo propio de esta entidad, llamado "nombreUsuarioRed", que está asociado con la relación entre migrante y red social. Para manejar este tipo de casos, es necesario crear una entidad que represente la relación muchos a muchos en sí misma y contenga sus propios atributos.

En el siguiente ejemplo de código se ilustra cómo se manejaría este caso en particular.

## Explicación de las notaciones mencionadas

`@ManyToMany`: Es una forma de establecer una relación de muchos a muchos entre dos entidades en una API.

`@JoinTable`: Se utiliza en una relación de base de datos para especificar la tabla intermedia que se utilizará para establecer una relación de muchos a muchos entre dos entidades. En otras palabras, cuando utilizamos la anotación `@JoinTable`, estamos creando una tabla intermedia que se utiliza para almacenar las relaciones entre dos tablas en una base de datos. Es comunmente usada cuando tenemos una relacion ManyToMany.

La notación `@JoinTable` tiene tres propiedades importantes: `name`, `joinColumns` e `inverseJoinColumns`. A continuación, se describen brevemente cada una de estas propiedades:

- `name`: Esta propiedad se utiliza para especificar el nombre de la tabla intermedia que se creará automáticamente para almacenar las relaciones entre las dos entidades. Por defecto, el nombre de la tabla intermedia se genera automáticamente utilizando los nombres de las dos entidades relacionadas. in embargo, podemos especificar un nombre personalizado para la tabla intermedia utilizando la propiedad "name" de la anotación @JoinTable.

- `joinColumns`: Esta propiedad se utiliza para especificar la columna de la tabla intermedia que se utilizará como clave externa que hace referencia a la tabla de origen de la relación. En otras palabras, se especifica la columna que se utilizará para hacer referencia a la entidad que tiene la anotación @JoinTable.

- `inverseJoinColumns`: Esta propiedad se utiliza para especificar la columna de la tabla intermedia que se utilizará como clave externa que hace referencia a la tabla de destino de la relación. En otras palabras, se especifica la columna que se utilizará para hacer referencia a la entidad relacionada con la entidad que tiene la anotación @JoinTable.
