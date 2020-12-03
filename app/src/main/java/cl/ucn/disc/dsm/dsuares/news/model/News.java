/*
 * Copyright 2020. Daniel Suares-Suares, daniel.suares@alumnos.ucn.cl
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package cl.ucn.disc.dsm.dsuares.news.model;

import net.openhft.hashing.LongHashFunction;

import org.threeten.bp.ZonedDateTime;

import cl.ucn.disc.dsm.dsuares.news.utils.Validation;

/**
 * The Domain model: News.
 *
 * @author Daniel Suares-Suares
 */
public final class News {

    /**
     * Unique id.
     */
    private final Long id;

    /**
     * The title.
     * Restrictions: not null, size > 2
     */
    private final String title;

    /**
     * The source.
     */
    private final String source;

    /**
     * The Author.
     */
    private final String author;

    /**
     * The URL.
     */
    private final String url;

    /**
     *  The URL of image.
     */
    private final String urlImage;

    /**
     * The Description.
     */
    private final String description;

    /**
     * The Content
     */
    private final String content;

    /**
     * The Date of publish.
     */
    private final ZonedDateTime publishedAt;

    /**
     * The Constructor.
     *
     * @param title       Can't be null.
     * @param source      Can't be null.
     * @param author      Can't be null.
     * @param url         to the main article.
     * @param urlImage    to the image.
     * @param description full article.
     * @param content     Can't be null.
     * @param publishedAt Can't be null.
     */
    public News(String title, String source, String author, String url, String urlImage, String description, String content, ZonedDateTime publishedAt) {

        // Title validation
        Validation.minSize(title, 2, "title");
        this.title = title;

        // Source validation
        Validation.minSize(source, 2, "source");
        this.source = source;

        // Author validation
        Validation.minSize(author, 3, "author");
        this.author = author;

        // Apply the xxHash function
        this.id = LongHashFunction.xx().hashChars(title + "|" + source + "|" + author);

        // URL Validation
        Validation.notNull(url, "URL");
        this.url = url;

        // URL Image Validation
        Validation.notNull(urlImage, "urlImg");
        this.urlImage = urlImage;

        // Description validation
        Validation.notNull(description,  "description");
        this.description = description;

        // Content validation
        Validation.notNull(content, "content");
        this.content = content;

        // PublishedAt validation
        Validation.notNull(publishedAt, "publishedAt");
        this.publishedAt = publishedAt;

    }

    /**
     * @return the id.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @return the title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return the source.
     */
    public String getSource() {
        return this.source;
    }

    /**
     * @return the author.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * @return the url.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * @return the urlImage.
     */
    public String getUrlImage() {
        return this.urlImage;
    }

    /**
     * @return the description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return the content.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * @return the publishedAt.
     */
    public ZonedDateTime getPublishedAt() {
        return this.publishedAt;
    }
}
