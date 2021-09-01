package com.example.irent;

public class AvailableHousesModel {

        String placeName;
        String countryName;
        String price;
        String imageUrl;

        //for firebase connection,construct the constructor below
        AvailableHousesModel(){

        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public AvailableHousesModel(String placeName, String countryName, String price, String imageUrl) {
            this.placeName = placeName;
            this.countryName = countryName;
            this.price = price;
            this.imageUrl = imageUrl;
        }

        public String getPlaceName() {
            return placeName;
        }

        public void setPlaceName(String placeName) {
            this.placeName = placeName;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

