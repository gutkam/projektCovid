package pl.sdacademy.jasonexample;

public class CovidApi {
        String country;
        String countryCode;
        String province;
        String city;
        Integer cityCode;
        Float lat;
        Float lon;
        Integer cases;
        String status;
        String date;

        public CovidApi(String country, String countryCode, String province, String city, Integer cityCode, Float lat, Float lon, Integer cases, String status, String date) {
            this.country = country;
            this.countryCode = countryCode;
            this.province = province;
            this.city = city;
            this.cityCode = cityCode;
            this.lat = lat;
            this.lon = lon;
            this.cases = cases;
            this.status = status;
            this.date = date;
        }

        @Override
        public String toString() {
            return "CovidApi{" +
                    "country='" + country + '\'' +
                    ", countryCode='" + countryCode + '\'' +
                    ", province='" + province + '\'' +
                    ", city='" + city + '\'' +
                    ", cityCode=" + cityCode +
                    ", lat=" + lat +
                    ", lon=" + lon +
                    ", cases=" + cases +
                    ", status='" + status + '\'' +
                    ", date='" + date + '\'' +
                    '}';
        }
}
