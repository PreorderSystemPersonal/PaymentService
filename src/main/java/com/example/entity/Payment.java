package com.example.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.AccessLevel;
import java.time.LocalDateTime;

@Entity
@Table(name="Payment_table")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "payment_id")
    private Long id;

    @Column
    private Long orderId;

    @Column
    private String userId;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime deletedAt;

    @Builder
    public Payment(Long orderId, String userId) {
        this.orderId = orderId;
        this.userId = userId;
    }

}
