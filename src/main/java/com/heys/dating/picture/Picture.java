package com.heys.dating.picture;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.google.appengine.api.datastore.ShortBlob;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.heys.dating.AbstractEntity;
import com.heys.dating.member.FileType;

@Entity
@Cache
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Picture extends AbstractEntity {
	private static final long serialVersionUID = 8418671229417665202L;

	String description;
	FileType fileType;
	ShortBlob full;
	ShortBlob icon;
	ShortBlob preview;
	PictureStatus state;
	PictureType type;
}
