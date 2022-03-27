package com.grupo3.realestaterental.domain;

class TableConstants {
    static class PropertyTable {
        static final String NAME = "property_table";

        static class Id {
            static final String NAME = "property_id";
        }

        static class Price {
            static final String NAME = "property_price";
        }

        static class Description {
            static final String NAME = "property_description";
            static final int LENGTH = 150;
        }

        static class Zone {
            static final String NAME = "property_zone";
            static final int LENGTH = 100;
        }

        static class ContactInfo {
            static final String NAME = "property_contact_info";
            static final int LENGTH = 50;
        }

        static class PublicationDate {
            static final String NAME = "property_publication_date";
        }
    }

    static class FileTable {
        static final String NAME = "files_table";
    }
}
