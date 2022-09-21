package uz.pdp.qayta_topshirish_5modul_sa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AttachmentContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private byte[] bytes;

    @OneToOne
    private Attachment attachment;

}
