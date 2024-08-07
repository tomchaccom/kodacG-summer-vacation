package com.example.week02.Dtos;

import com.example.week02.Entity.Product;
import lombok.Getter;

import java.util.Set;
import java.util.stream.Collectors;

/*
 * - 구현해야 하는 기능
 * - 상품 등록
 * - 상품 검색
 * - 상품 전체 조회(1페이지에 10개 정도)
 * - 상품 수정
 * - 상품 삭제
 * */

public class ProductDto {

    // 상품 등록
    public static class productRegist {
        private final String productName;
        private final String productDesc;
        private final int price;
        private final String image;

        public productRegist(String productName, String productDesc, int price, String image) {
            this.productName = productName;
            this.productDesc = productDesc;
            this.price = price;
            this.image = image;
        }
    }

    // 상품 검색
    public static class productSearch {
        private final String productName;
        private final String productDesc;
        private final String image;
        private Set<OptionDto> options; // OptionDto는 Option 엔티티를 대신할 DTO 클래스

        public productSearch(Product product) {
            this.productName = product.getProductName();
            this.productDesc = product.getProductDesc();
            this.image = product.getImage();
            this.options = product.getOptions().stream()
                    .map(option -> new OptionDto(option)) //  엔티티를 Dto로 만들고 set 리스트에 저장
                    .collect(Collectors.toSet());
        }
    }

    // 상품 페이지 전체 조회
    public static class productAllSearch {
        private final String productName;
        private final String productDesc;
        private final String image;
        private int page; // 페이지 번호

        public productAllSearch(Product product, int page) {
            this.productName = product.getProductName();
            this.productDesc = product.getProductDesc();
            this.image = product.getImage();
            this.page = page;
        }
    }

    // 상품 수정
    public static class productUpdate {
        private final String productName;
        private final String productDesc;
        private final String image;
        private final int price;

        public productUpdate(String productName, String productDesc, String image, int price) {
            this.productName = productName;
            this.productDesc = productDesc;
            this.image = image;
            this.price = price;
        }
    }

    // 상품 삭제
    @Getter
    public static class ProductDelete {
        private final String productName; // 상품 이름을 사용

        public ProductDelete(String productName) {
            this.productName = productName;
        }
    }

}
