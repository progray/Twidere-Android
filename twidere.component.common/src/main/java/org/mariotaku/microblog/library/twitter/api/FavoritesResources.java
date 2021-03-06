/*
 *                 Twidere - Twitter client for Android
 *
 *  Copyright (C) 2012-2015 Mariotaku Lee <mariotaku.lee@gmail.com>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mariotaku.microblog.library.twitter.api;

import org.mariotaku.microblog.library.MicroBlogException;
import org.mariotaku.microblog.library.twitter.model.Paging;
import org.mariotaku.microblog.library.twitter.model.ResponseList;
import org.mariotaku.microblog.library.twitter.model.Status;
import org.mariotaku.microblog.library.twitter.template.StatusAnnotationTemplate;
import org.mariotaku.restfu.annotation.method.GET;
import org.mariotaku.restfu.annotation.method.POST;
import org.mariotaku.restfu.annotation.param.Param;
import org.mariotaku.restfu.annotation.param.Queries;
import org.mariotaku.restfu.annotation.param.Query;

@SuppressWarnings("RedundantThrows")
@Queries(template = StatusAnnotationTemplate.class)
public interface FavoritesResources {

    @POST("/favorites/create.json")
    Status createFavorite(@Param("id") String id) throws MicroBlogException;

    @POST("/favorites/destroy.json")
    Status destroyFavorite(@Param("id") String id) throws MicroBlogException;

    @GET("/favorites/list.json")
    ResponseList<Status> getFavorites() throws MicroBlogException;

    @GET("/favorites/list.json")
    ResponseList<Status> getFavorites(@Query("user_id") String userId, @Query Paging paging) throws MicroBlogException;

    @GET("/favorites/list.json")
    ResponseList<Status> getFavoritesByScreenName(@Query("screen_name") String screenName, @Query Paging paging) throws MicroBlogException;
}
