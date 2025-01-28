package com.Anath.ItemDelivery;

import jdk.jfr.events.CertificateId;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter

public class Item {

    @Id
    @GeneratedValue(strategy = )
    private Long id;
    private String name;

}
